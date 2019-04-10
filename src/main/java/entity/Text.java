package entity;

import java.util.Arrays;
import java.util.Objects;

public class Text {
    private String text;
    private String[] preparedText;
    private Dictionary dictionary;
    private String kernel;

    public Text(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String[] getPreparedText() {
        return preparedText;
    }

    public void setPreparedText(String[] preparedText) {
        this.preparedText = preparedText;
    }

    public Dictionary getDictionary() {
        return dictionary;
    }

    public void setDictionary(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

   /* @Override
    public String toString() {
        return "Text{" +
                "text='" + text
                + "kernel='" + kernel;
    } */

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Text text1 = (Text) o;
        return text.equals(text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }

    public String getKernel() {
        return kernel;
    }

    public void setKernel(String kernel) {
        this.kernel = kernel;
    }

    @Override
    public String toString() {
        return //"Text{" +
                 text + '\'' +
               // ", preparedText=" + Arrays.toString(preparedText) +
               // ", dictionary=" + dictionary +
                " kernel='" + kernel + '\n';
               // '}';
    }
}
