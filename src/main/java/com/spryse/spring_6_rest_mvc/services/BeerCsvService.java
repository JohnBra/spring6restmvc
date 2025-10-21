package com.spryse.spring_6_rest_mvc.services;

import com.spryse.spring_6_rest_mvc.models.BeerCSVRecord;

import java.io.File;
import java.util.List;

public interface BeerCsvService {
    List<BeerCSVRecord> convertCSV(File csvFile);
}
