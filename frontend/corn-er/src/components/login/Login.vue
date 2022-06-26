<template>

  <div class="login-container">
    <label for="uname"><b>Username</b></label>
    <input type="text" placeholder="Enter Username" name="uname" required>

    <label for="psw"><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="psw" required>

    <button class="green-btn" type="submit" @click="login">Login</button>
    <label>
      <input type="checkbox" checked="checked" name="remember"> Remember me
    </label>
  </div>


</template>

<script>
export default {
    methods: {
        login() {
            this.$router.push({ path: '/users/1' })
        }
    }
}
</script>

<style>
    .login-container {
        max-width: 400px;
    }
</style>