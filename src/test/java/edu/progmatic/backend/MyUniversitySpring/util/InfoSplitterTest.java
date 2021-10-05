package edu.progmatic.backend.MyUniversitySpring.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InfoSplitterTest {

    @Test
   public void splitRequirementsTest(){
       String nullInput = "NULL";
       String singleInput = "ANG-455";
       String multipleInput = "ANG-455|ANG-445*|ANG-435";

       List<String> sigleList = List.of("ANG-455");
       List<String> multipleList = List.of("ANG-455", "ANG-445*", "ANG-435");

       Assertions.assertTrue(InfoSplitter.splitRequirements(nullInput).isEmpty());
       Assertions.assertTrue(compareLists(sigleList, InfoSplitter.splitRequirements(singleInput)));
       Assertions.assertTrue(compareLists(multipleList, InfoSplitter.splitRequirements(multipleInput)));

   }

   @Test
    public void splitSemestersTest(){

        String singleInput = "4";
        String multipleInput ="2|3|4";

        List<Integer> sigleList = List.of(4);
        List<Integer> multipleList = List.of(2,3,4);


        Assertions.assertTrue(compareLists(sigleList, InfoSplitter.splitSemesters(singleInput)));
        Assertions.assertTrue(compareLists(multipleList, InfoSplitter.splitSemesters(multipleInput)));

    }

   public <T> boolean compareLists(List <T> expected, List <T> actual){
       if(expected.size()!=actual.size()){return false;}

       for (int i = 0; i < expected.size(); i++) {
           if(!expected.get(i).equals(actual.get(i))){
               return false;
           }
       }
       return true;
   }

}