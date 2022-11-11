<template>
<div id="app">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
      <ul class="navbar-nav me-auto">
        <li class="nav-item"><router-link to="/" class="nav-link bg-info text-white">Dept</router-link></li>
        |
        <li class="nav-item"><router-link to="/emp" class="nav-link bg-warning text-white">Emp</router-link></li>
      </ul>
    </nav>
    <router-view></router-view>
  </div>
</template>

<script>

export default {
  name: "App",
};
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}
</style>