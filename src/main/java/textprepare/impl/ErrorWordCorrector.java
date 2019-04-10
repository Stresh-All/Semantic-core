package textprepare.impl;

import org.languagetool.JLanguageTool;
import org.languagetool.language.Russian;
import org.languagetool.rules.Rule;
import org.languagetool.rules.RuleMatch;
import textprepare.Preparing;

import java.io.IOException;
import java.util.List;

public class ErrorWordCorrector implements Preparing {

    @Override
    public String[] prepare(String[] text) {
        String[] correct = new String[text.length];
        for (int i = 0; i < text.length; i++){
            try {
                text[i] = prepare(text[i]);
            } catch (IOException e) {
                continue;
            }
        }
        return text;
    }

    private String prepare (String word) throws IOException {
        JLanguageTool langTool = new JLanguageTool(new Russian());
        for (Rule rule : langTool.getAllRules()) {
            if (!rule.isDictionaryBasedSpellingRule()) {
                langTool.disableRule(rule.getId());
            }
        }
        List<RuleMatch> matches = langTool.check(word);
        String answer = word;
        for (RuleMatch match : matches) {
            System.out.println("Potential typo at characters " +
                    match.getFromPos() + "-" + match.getToPos() + ": " +
                    match.getMessage());
            System.out.println("Suggested correction(s): " +
                    match.getSuggestedReplacements());
            List<String> matche = match.getSuggestedReplacements();
            if (matche != null && !matche.isEmpty()){
                answer = matche.get(0);
            }
        }
        return answer;
    }
}
