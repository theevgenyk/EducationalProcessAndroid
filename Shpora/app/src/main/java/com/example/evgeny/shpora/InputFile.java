package com.example.evgeny.shpora;

import android.content.Context;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class InputFile {
    private Context context;
    private String name;

    public InputFile(Context context, String name) {
        this.context = context;
        this.name = name;
    }

    public String readFile() {
        String data = "";
        String line = null;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(name)));
            while ((line = reader.readLine()) != null) {
                data += line;
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return data;
    }
}

