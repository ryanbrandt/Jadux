# Jadux: State Management for Java Applications

I like Redux, and got tired of manually figuring out state management everytime I pivoted over to Java. So I built Jadux, which provides a boilderplate and similiar patterns to those you probably know from Redux.

If you're not familiar with Redux, [the docs may be a good start](https://redux.js.org/).

# Usage

Jadux contains everything you know from Redux, action types, actions, reducers and your store.

## Creating Your Store

```java
import com.ryanbrandt.jadux.Jadux;

// ...

Jadux.createStore();
```

You're obviously limited to creating one store per application. Duh.
Jadux won't nuke your state if you call createStore twice, but it will throw an exception.

## Defining Action Types and Actions

```java
import com.ryanbrandt.jadux.Jadux;

// ...

Jadux.registerActionType("MY_ACTION_TYPE");
Jadux.registerAction("MY_ACTION_TYPE");
```

This is slightly different from Redux where we'd do something like

```javascript
const MY_ACTION_TYPE = "MY_ACTION_TYPE";

const myAction = () => {
  return {
    type: MY_ACTION_TYPE,
  };
};
```

If we need to pass a payload with our Action

But the same general idea applies. Create your action type, then create your action creator.

## Defining Reducers

Since we're using Java we're locked into OOP. So, when you go to create a Reducer, you need to implement the Jadux Reducer interface

```java
import com.ryanbrandt.jadux.Reducer;

public class MyReducer implements Reducer {

    public void reduce(Action a) {
        // ...
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

Similiar to Redux, it would make sense to seperate state into multiple Reducers where each Reducer deals with a logical grouping of state values.

## Dispatching Actions

```java
import com.ryanbrandt.jadux.Jadux;
import com.ryanbrandt.jadux.action.Dispatch;

// ...

Dispatch.send(Jadux.getApplicationAction("MY_ACTION_TYPE"));
```
