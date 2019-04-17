package com.bytedancer.mockitodemo;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import org.junit.runner.*;
import org.mockito.*;
import org.mockito.junit.*;

@RunWith(MockitoJUnitRunner.class)
public class InjectTests {

    public class MyDictionary {

        Map<String, String> wordMap;

        public MyDictionary() {
            wordMap = new HashMap<>();
        }

        public void add(final String word, final String meaning) {
            wordMap.put(word, meaning);
        }

        public String getMeaning(final String word) {
            return wordMap.get(word);
        }
    }

    @Mock
    Map<String, String> wordMap;

    @InjectMocks
    MyDictionary dic = new MyDictionary();

    @Test
    public void whenUseInjectMocksAnnotation_thenCorrect() {
        Mockito.when(wordMap.get("aWord")).thenReturn("aMeaning");

        Assert.assertEquals("aMeaning", dic.getMeaning("aWord"));
    }
}
