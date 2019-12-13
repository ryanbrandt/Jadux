# Jadux: State Management for Java Applications

I like Redux, and got tired of manually figuring out state management everytime I pivoted over to Java. So I built Jadux, which provides a boilerplate and similiar patterns to those you probably know from Redux.

# Usage

Jadux attempts to copy the big 3 from Redux, Actions, Reducers and your Store.

## Creating Your Store

```java
import com.ryanbrandt.jadux.Jadux;

// ...

Jadux.createStore();
```

You're obviously limited to creating one store per application.

## Defining Actions

```java
import com.ryanbrandt.jadux.Jadux;
import com.ryanbrandt.jadux.models.IntegerData;

// ...

Jadux.registerAction(new Action<IntegerData>);
```

This is slightly different from Redux in JS where we'd do something like

```javascript
const MY_ACTION_TYPE = "MY_ACTION_TYPE";

const myAction = payload => {
  return {
    type: MY_ACTION_TYPE,
    payload,
  };
};
```

You must parameterize your Action-- this defines the type of payload your Action ships. Jadux includes models for typical payloads, String, Integer, and so on.

If you need to define your own payload types, simply implement the JaduxData interface.

```java
public final class ArrayData implements JaduxData {
    private ArrayList<Object> value;

    public ArrayData(ArrayList<Object> value) {
        this.value = value;
    }

    // ...
```

## Defining Reducers

To get started defining your reducer, you must extend the Reducer class, and implement its abstract method, reduce.

You can do this any way you would like, but I tried to mimic Redux patterns in the example. The general idea is to get a HashMap with the state key-values you would like to add or update.

You <b>must</b> call commit at the end of your reduce method update state.

```java
import com.ryanbrandt.jadux.Reducer;

import static com.myapp.constants.Actions;

public class TestReducer extends Reducer {

        public void reduce(Action<? extends JaduxData> a) {
            HashMap<String, JaduxData> updatedState = new HashMap<>();

            switch (a.getType()) {

            case INTEGER_DATA_ACTION: {
                updatedState.put("foo", a.getPayload());
                break;
            }

            case STRING_DATA_ACTION: {
                updatedState.put("bar", a.getPayload());
                break;
            }

            }

            this.commit(updatedState);
        }
    }

```

Then elsewhere we can add our Reducer to the application

```java
import com.ryanbrandt.jadux.Jadux;

import com.myapp.reducers.MyReducer;

// ...

Jadux.registerReducer(new MyReducer());
```

It would probably make sense to seperate state into multiple Reducers where each Reducer deals with a logical grouping of state key-values (e.g. SearchReducer, ShoppingCartReducer)

## Dispatching Actions

```java
import com.ryanbrandt.jadux.Jadux;
import com.ryanbrandt.jadux.action.Dispatch;

import static com.myapp.constants.Actions;

// ...

Dispatch.send(
  Jadux.getApplicationAction(STRING_DATA_ACTION)
          .setPayload(new StringData("jadux sucks"))
);
```

If we dont call setPayload every time we send an Action, you will send a null payload!
