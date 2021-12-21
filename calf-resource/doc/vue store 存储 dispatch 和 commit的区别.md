# vue store 存储 dispatch 和 commit的区别

## dispatch: 含有异步操作

存储：

```kotlin
this.$store.dispatch('initUserInfo',friend);
```

取值：

```kotlin
this.$store.getters.userInfo;
```

## commit:同步操作

存储：

```kotlin
this.$store.commit('initUserInfo',friend);
```

取值：

```kotlin
this.$store.state.userInfo;
```

