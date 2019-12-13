package com.ryanbrandt.jadux;

import java.util.HashMap;

import org.junit.Assert;

import com.ryanbrandt.jadux.action.Action;
import com.ryanbrandt.jadux.application.Jadux;
import com.ryanbrandt.jadux.models.JaduxData;
import com.ryanbrandt.jadux.reducer.Reducer;

import org.junit.Test;

public class ReducerTest {

    public class TestReducer extends Reducer {

        public void reduce(Action<? extends JaduxData> a) {
            HashMap<String, JaduxData> updatedState = new HashMap<>();

            switch (a.getType()) {

            case ActionTest.INTEGER_DATA_ACTION: {
                updatedState.put("foo", a.getPayload());
                break;
            }

            case ActionTest.STRING_DATA_ACTION: {
                updatedState.put("bar", a.getPayload());
                break;
            }

            }

            this.commit(updatedState);
        }
    }

    @Test
    public void shouldAddReducers() {
        Assert.assertEquals(0, Jadux.getNumReducers());
        Jadux.registerReducer(new TestReducer());
        Assert.assertEquals(1, Jadux.getNumReducers());
    }
}