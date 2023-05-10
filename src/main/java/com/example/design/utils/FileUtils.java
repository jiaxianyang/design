package com.example.design.utils;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Objects;

@Slf4j
public class FileUtils {

    public static List<String> readFile(String filePath) throws IOException {
        Reader reader = null;
        BufferedReader br = null;
        List<String> result = Lists.newArrayList();
        try {
            reader = new InputStreamReader(Objects.requireNonNull(org.apache.tomcat.util.http.fileupload.FileUtils.class.getClassLoader().getResourceAsStream(filePath)), "UTF-8");
            br = new BufferedReader(reader);
            String line;
            while ((line = br.readLine()) != null) {
                result.add(StringUtils.trim(line));
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (br != null) {
                br.close();
            }
        }
        return result;
    }
}
