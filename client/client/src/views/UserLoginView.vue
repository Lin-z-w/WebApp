<template>
  <div id="app">
    <div class="form-container">
      <el-form ref="loginForm" :model="loginForm" :rules="rules" label-width="100px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="loginForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="loginForm.password"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit()">登录</el-button>
            <el-button type="success" @click="goToReg()">注册</el-button>
        </el-form-item>
      </el-form>
    </div>
  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      loginForm: {
        username: '',
        password: '',
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
        ],
      }
    }
  },
  methods: {
    onSubmit() {
      this.$refs.loginForm.validate((valid) => {
        if (valid) {
            axios.post(this.$store.state.backendPort + '/login', this.loginForm, {
                headers: {
                    'Content-Type': 'application/json'
                }}
            )
            .then(response => {
                console.log(response.data.data);
                if(response.status == 200){
                    this.$store.commit('setUser', { 'token': response.data.data.token, 'userInfo': response.data.data.userInfo });
                    this.$router.push('/product');
                }else{
                    alert("登录失败！");
                }
            })
            .catch(error => {
                console.log('error ' + error);
            });
        } else {
          console.log('表单验证失败')
          return false
        }
      })
    },
    goToReg(){
        this.$router.push('/register');
    }
  }
}
</script>

<style>

body {
  background-image: url('https://img1.baidu.com/it/u=3255982679,2651472561&fm=253&fmt=auto&app=138&f=PNG?w=1076&h=500'); /* 替换为你背景图片的路径 */
  background-size: cover; /* 根据需要调整背景图的大小 */
  background-position: center; /* 根据需要调整背景图的位置 */
  background-repeat: no-repeat; /* 防止背景图重复 */
  margin: 0;
  font-family: 'Arial', sans-serif;
}

#app {
  width: 400px;
  margin: 100px auto;
}

.form-container {
  border: 1px solid #dcdcdc;
  padding: 20px;
  border-radius: 8px;
  background-color: #fff;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
}
</style>
