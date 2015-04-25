package linesreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinesReader {
    private IEvents events;
    BufferedReader br;

    public LinesReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setEvents(IEvents events) {
        this.events = events;
    }

    public void read() {
        if (events != null) {
            try {
                events.onNewLine(br.readLine());
            } catch (IOException e) {
                events.onError(e.toString());
            }
        }
    }
}