<template>
  <div id="app">
    <nav class="navbar navbar-expand-sm bg-dark navbar-dark mb-3">
      <ul class="navbar-nav me-auto">
        <li class="nav-item"><router-link to="/" class="nav-link bg-info text-white">Dept</router-link></li>
        |
        <li class="nav-item"><router-link to="/emp" class="nav-link bg-warning text-white">Emp</router-link></li>
      </ul>
      <span class="bg-success badge">ver. vuex</span>
    </nav>
    <router-view></router-view>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
