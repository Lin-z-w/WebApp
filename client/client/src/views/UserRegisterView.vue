<template>
  <div id="app">
    <div class="form-container">
      <el-form ref="registerForm" :model="registerForm" :rules="rules" label-width="100px">
        <el-form-item label="用户名" prop="username">
          <el-input v-model="registerForm.username"></el-input>
        </el-form-item>
        <el-form-item label="密码" prop="password">
          <el-input type="password" v-model="registerForm.password"></el-input>
        </el-form-item>
        <el-form-item label="邮箱" prop="email">
          <el-input v-model="registerForm.email"></el-input>
        </el-form-item>
        <el-form-item label="地址" prop="address">
          <el-input v-model="registerForm.address"></el-input>
        </el-form-item>
        <el-form-item label="手机号" prop="phone">
          <el-input v-model="registerForm.phone"></el-input>
        </el-form-item>
        <el-form-item>
            <el-button type="primary" @click="onSubmit">完成注册</el-button>
            <el-button type="info" @click="goToLogin">返回登录界面</el-button>
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
      registerForm: {
        username: '',
        email: '',
        password: '',
        address: '',
        phone: ''
      },
      rules: {
        username: [
          { required: true, message: '请输入用户名', trigger: 'blur' },
          { min: 3, max: 15, message: '用户名长度在3到15个字符', trigger: 'blur' }
        ],
        email: [
          { required: true, message: '请输入邮箱地址', trigger: 'blur' },
          { type: 'email', message: '请输入正确的邮箱地址', trigger: ['blur', 'change'] }
        ],
        password: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          { min: 6, message: '密码长度不能少于6位', trigger: 'blur' }
        ],
        address: [
          { required: true, message: '请输入地址', trigger: 'blur' },
        ],
        phone: [
          { required: true, message: '请输入手机号', trigger: 'blur' },
          { min: 11, max:11, message: '手机号必须为11位', trigger: 'blur' }
        ]
      }
    }
  },
  methods: {
    onSubmit() {
      this.$refs.registerForm.validate((valid) => {
        if (valid) {
            axios.post(this.$store.state.backendPort + '/register', this.registerForm, {
                headers: {
                    'Content-Type': 'application/json'
                }}
            )
            .then(response => {
                console.log(response.data.data);
                if(response.status == 200){
                    this.$router.push('/login');
                }else{
                    alert("用户名已被注册！");
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
    goToLogin(){
        this.$router.push('/login');
    }
  }
}
</script>

<style>

body {
  background-image: url('https://img.zcool.cn/community/018ce8578dc8b30000018c1b17db4a.jpg@3000w_1l_0o_100sh.jpg'); /* 替换为你背景图片的路径 */
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
