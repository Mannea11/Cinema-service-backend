package com.Gruppuppgift.Cinema.Service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CurrencyConverterService {

        public static double convertCurrency(String from, String to, double amount) throws IOException {
            URL url = new URL("https://api.api-ninjas.com/v1/convertcurrency?want=" + to + "&have=" + from + "&amount=" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            return root.path("new_amount").asDouble();
        }
    }


