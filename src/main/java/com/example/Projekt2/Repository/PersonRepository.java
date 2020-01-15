package com.example.Projekt2.Repository;

import com.example.Projekt2.Domain.Person;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>  {
    List<Person> persons = new ArrayList<>();
    List<Person> findAll();

    Person findByNick(String nick);

    Person findById(int id);

    Person findByEmail(String email);

     static void exportCsvFile() {
        String csvExported = "./exported.csv";
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(csvExported));
        ) {

            StatefulBeanToCsv<Person> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
            beanToCsv.write(persons);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        }
    }
}
