package linesreader;

public interface IEvents {
    void onNewLine(String line);
    void onError(String msg);
}
