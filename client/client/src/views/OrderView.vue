<template>
    <div>
        <el-dialog :visible.sync="dialogTableVisible" title="订单详情" :close-on-click-modal="false" >
            <div style="display: flex;">
                <span style="margin-right: 20px">
                    <img :src="showOrder.img" alt="商品图片" style="height: 200px" />
                </span>
                <span style="font-size: 20px; font-weight: 800">
                    <p>订单日期： {{ showOrder.date }}</p>
                    <p>商品名称： {{ showOrder.productName }}</p>
                    <p>购买数量： {{ showOrder.quantity }}</p>
                    <p>总价： ¥{{ showOrder.totalPrice }}</p>
                    <p>目的地址： {{ showOrder.address }}</p>
                    <p>联系电话： {{ showOrder.phone }}</p>
                </span>
            </div>
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
                        <el-table :data="tableData" style="width: 100%" max-height="500">
                            <el-table-column fixed prop="img" label="商品图片" width="150">
                                <template slot-scope="scope">
                                    <img :src="scope.row.img" class="avatar" style="width: 100px; height: 100px">
                                </template>
                            </el-table-column>
                            <el-table-column fixed prop="orderDate" label="订单日期" width="150">
                            </el-table-column>
                            <el-table-column prop="productName" label="商品名称" width="120">
                                <template slot-scope="scope">
                                    <div class="text-truncate">{{ scope.row.productName }}</div>
                                </template>
                            </el-table-column>
                            <el-table-column prop="quantity" label="商品数量" width="120">
                            </el-table-column>
                            <el-table-column prop="totalPrice" label="商品总价" width="120">
                            </el-table-column>
                            <el-table-column prop="address" label="目的地址" width="300">
                                <template slot-scope="scope">
                                    <div class="text-truncate">{{ scope.row.address }}</div>
                                </template>
                            </el-table-column>
                            <el-table-column prop="phone" label="联系电话" width="300">
                            </el-table-column>
                            <el-table-column fixed="right" label="操作" width="120">
                                <template slot-scope="scope">
                                    <el-button @click="showDetail(scope.row)" type="text" size="small">详情</el-button>
                                </template>
                            </el-table-column>
                        </el-table>
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
            tableData: [
                {
                    orderDate: '2015-1-2',
                    productName: "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",
                    quantity: 3,
                    totalPrice: 200,
                    address: 'njussssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss',
                    phone: '1511111111',
                    img: 'https://img2.baidu.com/it/u=834353633,3918527013&fm=253&fmt=auto&app=138&f=PNG?w=190&h=209'
                },
            ], // 订单列表
            showOrder: {
                date: '',
                productName: '',
                quantity: 0,
                totalPrice: 0,
                address: '',
                phone: '',
                img: '',
            },
            dialogTableVisible: false,
        }
    },
    methods: {
        showDetail(order){
            this.showOrder.date = order.orderDate;
            this.showOrder.productName = order.productName;
            this.showOrder.quantity = order.quantity;
            this.showOrder.totalPrice = order.totalPrice;
            this.showOrder.address = order.address;
            this.showOrder.phone = order.phone;
            this.showOrder.img = order.img;
            this.dialogTableVisible = true;
        }
    },
    mounted() {
        axios.get(this.$store.state.backendPort + "/order/" + this.$store.state.user.username, {
            headers: {
                'token': this.$store.state.user.token,
            }
        }).then((result) => {
            this.tableData = result.data;
        }).catch(error => {
            if(error.code == -2){
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

  .text-truncate {
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    max-width: 100%;
    }
</style>