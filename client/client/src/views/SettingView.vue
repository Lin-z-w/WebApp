<template>
    <div>
        <el-dialog :visible.sync="dialogFormVisible" title="修改个人信息" :close-on-click-modal="false"> 
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="邮箱" prop="email" :rules="[
                    { required: true, message: '邮箱不能为空'},
                    ]"
                >
                    <el-input v-model="form.email"></el-input>
                </el-form-item>

                <el-form-item label="手机号码" prop="phone" :rules="[
                    { required: true, message: '手机号码不能为空'},
                    ]"
                >
                    <el-input v-model="form.phone" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="地址" prop="address" :rules="[
                    { required: true, message: '地址不能为空'},
                    ]"
                >
                    <el-input v-model="form.address" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="用户头像">
                    <el-upload
                        class="upload-demo"
                        drag
                        :action="uploadUrl('/uploadImage')"
                        :on-success="loadImgUrl"
                    >
                        <i class="el-icon-upload"></i>
                        <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
                        <div class="el-upload__tip" slot="tip">只能上传jpg/png文件，且不超过500kb</div>
                    </el-upload>
                </el-form-item>

                <el-form-item>
                    <el-button type="primary" @click="onSubmit()">提交</el-button>
                    <el-button @click="dialogFormVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-dialog :visible.sync="rechargeFormVisible" title="充值" :close-on-click-modal="false">
            <el-form ref="form" :model="money" label-width="80px">
                <el-form-item label="充值金额" prop="money" :rules="[
                    { required: true, message: '价格不能为空'},
                    { type: 'number', message: '价格必须为数字值'}
                    ]"
                >
                    <el-input v-model.number="money.amount" autocomplete="off"></el-input>
                </el-form-item>
                <el-form-item>
                    <el-button type="primary" @click="recharge()">充值</el-button>
                    <el-button @click="dialogFormVisible = false">取消</el-button>
                </el-form-item>
            </el-form>
        </el-dialog>

        <el-container style="height: 750px; border: 1px solid #eee">
            <el-header style="height: 100px; font-size: 50px; background-color: #1976d2; color: #fff; line-height: 100px; font-weight: 1000;">
                <i class="el-icon-s-home"></i>
                电商平台 
                <span style="height: 100px; font-size: 20px; font-weight: 700;">联系电话：11451419198</span>
            </el-header>
            
            <el-container>
                <el-aside width="200px">
                    <el-menu default-active="1" class="el-menu-vertical-demo" :collapse="isCollapse">
                    <el-menu-item index="0" style="height: 60px; background-color: #B3C0D1">
                        <i class="el-icon-menu"></i>
                        <span style="font-size: 25px;">菜单选项</span>
                    </el-menu-item>
                    <el-submenu index="1">
                        <template #title>
                            <i class="el-icon-s-goods"></i>
                            <span class="aside-choose">商品列表</span>
                        </template>

                        <router-link to="/product" class="no-display">
                            <el-menu-item index="1-0">
                                <i class="el-icon-goods"></i>
                                全部商品
                            </el-menu-item>
                        </router-link>

                        <router-link to="/product/book" class="no-display">
                        <el-menu-item index="1-1">
                            <i class="el-icon-collection"></i>
                            书籍
                        </el-menu-item>
                        </router-link>
                        
                        <router-link to="/product/food" class="no-display">
                        <el-menu-item index="1-2">
                            <i class="el-icon-food"></i>
                            食品
                        </el-menu-item>
                        </router-link>

                        <router-link to="/product/vehicle" class="no-display">
                        <el-menu-item index="1-2">
                            <i class="el-icon-bicycle"></i>
                            交通工具
                        </el-menu-item>
                        </router-link>
                    </el-submenu>
                    <router-link to="/order" class="no-display">
                    <el-menu-item index="2">
                        <i class="el-icon-s-order"></i>
                        <span class="aside-choose">
                            订单列表
                        </span>
                    </el-menu-item>
                    </router-link>
                    <router-link to="/setting" class="no-display">
                    <el-menu-item index="3">
                        <i class="el-icon-setting"></i>
                        <span class="aside-choose">
                            个人设置
                        </span>
                    </el-menu-item>
                    </router-link>
                    <router-link to="/shopping" class="no-display">
                    <el-menu-item index="4">
                        <i class="el-icon-shopping-cart-2"></i>
                        <span class="aside-choose">
                            购物车
                        </span>
                    </el-menu-item>
                    </router-link>
                    
                    </el-menu>
                </el-aside>
        
                <el-container>
                    <el-header style="font-size: 12px; height: 60px">
                        
                    </el-header>
                    
                    <el-main style="background-color: #fff; color: #333">
                         
                        <el-descriptions class="margin-top" title="用户信息" :column="1" :size="size" border>
                            <template slot="extra">
                            <el-button type="primary" style="line-height: 20px; font-size: 20px; font-weight: 700" @click="dialogFormVisible = true">修改个人信息</el-button>
                            <el-button type="danger" style="line-height: 20px; font-size: 20px; font-weight: 700" @click="exit()">退出登录</el-button>
                            </template>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-picture-outline"></i>
                                    头像
                                </template>
                                <img :src="getProfile()" class="profile" style="width: 200px; height: 200px; border-radius: 50%;">
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-user"></i>
                                    用户名
                                </template>
                                {{ $store.state.user.username }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-mobile-phone"></i>
                                    手机号
                                </template>
                                {{ $store.state.user.telephone }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-location-outline"></i>
                                    地址
                                </template>
                                {{ $store.state.user.address }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-message"></i>
                                    邮箱
                                </template>
                                {{ $store.state.user.email }}
                            </el-descriptions-item>
                            <el-descriptions-item>
                                <template slot="label">
                                    <i class="el-icon-money"></i>
                                    余额
                                </template>
                                <div style="justify-content: space-between; align-items: center; display: flex;">
                                    {{ $store.state.user.balance }}
                                    <el-button type="success" style="line-height: 10px; font-size: 20px; font-weight: 700" @click="rechargeFormVisible = true">充值</el-button>
                                </div>
                            </el-descriptions-item>
                        </el-descriptions>

                    </el-main>
                </el-container>
            </el-container>
        </el-container>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    data() {
        return {
            size: '',

            dialogFormVisible: false,
            rechargeFormVisible: false, 
            form: {
                username: this.$store.state.user.username,
                email: this.$store.state.user.email,
                phone: this.$store.state.user.telephone,
                address: this.$store.state.user.address,
                img: this.$store.state.user.img
            },
            money: {
                amount: 0.0,
                username: '',
            }
        }
    },
    methods: {
        onSubmit(){
            this.$refs.form.validate(valid => {
                if (valid) {
                    axios.post(this.$store.state.backendPort + '/user', this.form, {
                        headers: {
                            'Content-Type': 'application/json',
                            'token': this.$store.state.user.token,
                        }}
                    )
                    .then(response => {
                        if(response.status == 200){
                            this.$store.commit('setUser', { 'token': this.$store.state.user.token, 'userInfo': response.data.data });
                            this.$message.success('修改成功');
                        }
                    })
                    .catch(error => {
                        if(error.response.data.code == -2){
                            this.$message('用户尚未登录！');
                            this.$router.push('/login');
                            return;
                        }
                    });
                } else {
                    console.log('upload fail');
                }
            });
        },
        getProfile(){
            return this.$store.state.user.img;
        },
        uploadUrl(path){
            return this.$store.state.backendPort + path;
        },
        loadImgUrl(response){
            this.form.img = response.data;
        },
        recharge(){
            this.money.username = this.$store.state.user.username;
            this.$refs.form.validate(valid => {
                if (valid) {
                    axios.post(this.$store.state.backendPort + '/user', this.money, {
                        headers: {
                            'Content-Type': 'application/json',
                            'token': this.$store.state.user.token,
                        }}
                    )
                    .then(response => {
                        if(response.status == 200){
                            this.$store.commit('setBalance', { 'balance': response.data.data.balance });
                        }else{
                            alert("充值失败");
                        }
                    })
                    .catch(error => {
                        if(error.response.data.code == -2){
                            this.$message('用户尚未登录！');
                            this.$router.push('/login');
                            return;
                        }
                    });
                } else {
                    console.log('upload fail');
                }
            });
        },
        exit(){
            this.$router.push('/login');
        }
    },
    mounted() {
        axios.get(this.$store.state.backendPort + "/user/" + this.$store.state.user.username, {
            headers: {
                'token': this.$store.state.user.token,
            }}
        ).then((result) => {
            this.$store.commit('setUser', { 'token': this.$store.state.user.token, 'userInfo': result.data.data });
        }).catch(error => {
            if(error.response.data.code == -2){
                this.$message('用户尚未登录！');
                this.$router.push('/login');
                return;
            }
        });
    },
}
</script>

<style>
  .el-header {
    background-color: #B3C0D1;
    color: #333;
    height: 60px;
  }
  
  .el-aside {
    background-color: #f5f5f5; 
    color: #333;
  }

  .aside-choose {
    font-size: 20px;
  }

  .no-display{
    text-decoration: none;
  }

  .search-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100%; 
  }

  .product-image {
    width: 100px;
    height: 100px;
  }   

  .footer {
    bottom: 0;
    left: 1;
    width: 88%;
    background-color: #f2f2f2; 
    text-align: right; 
    display: flex; 
    justify-content: space-between; 
    align-items: center; 
    height: 100px; 
    position: fixed;
  }   
</style>