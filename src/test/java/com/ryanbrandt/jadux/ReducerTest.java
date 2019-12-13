package com.ryanbrandt.jadux;

import java.util.HashMap;

import org.junit.Assert;

import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.application.Jadux;
import com.ryanbrandt.jadux.models.IntegerData;
import com.ryanbrandt.jadux.models.JaduxData;
import com.ryanbrandt.jadux.models.StringData;
import com.ryanbrandt.jadux.reducer.Reducer;

import org.junit.Test;

public class ReducerTest {

    public class TestReducer implements Reducer {

        public HashMap<String, JaduxData> reduce(Action<? extends JaduxData> a, HashMap<String, JaduxData> state) {
            switch (a.getType()) {

            case ActionTest.INTEGER_DATA_ACTION: {
                state.replace("foo", new IntegerData(1));
                return state;
            }

            case ActionTest.STRING_DATA_ACTION: {
                HashMap<String, JaduxData> updatedValues = new HashMap<>();
                {
                    updatedValues.put("bar", new StringData("yeet"));
                }
                return updatedValues;
            }

            default: {
                return state;
            }

            }
        }
    }

    @Test
    public void shouldAddReducers() {
        Assert.assertEquals(0, Jadux.getNumReducers());
        Jadux.registerReducer(new TestReducer());
        Assert.assertEquals(1, Jadux.getNumReducers());
    }
}