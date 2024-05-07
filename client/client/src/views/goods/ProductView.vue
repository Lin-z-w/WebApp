<template>
    <div>
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
                        <div class="search-container">
                            <el-input v-model="searchValue" placeholder="请输入商品名称" @keyup.enter="handleSearch" clearable>
                                <el-button slot="append" icon="el-icon-search" @click="handleSearch"></el-button>
                            </el-input>
                        </div>
                    </el-header>
                    
                    <el-main style="background-color: #fff; color: #333">
                        

                        
                    </el-main>
                    <el-footer>
                        <el-pagination background layout="sizes, prev, pager, next, jumper, total" 
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :total="total"
                            :page-sizes="[10, 20, 30]"
                            :page-size="pageSize">
                        </el-pagination>
                    </el-footer>
                    <el-footer style="background-color: #f2f2f2; text-align: center;">
                        
                    </el-footer>
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
            searchValue: "",
            products: [],
            isCollapse: false,

            displayProducts: [],

            // 分页
            total: 0,
            pageSize: 10,
            currentPage: 1,
        }
    },
    methods: {
        handleSearch(){
            this.displayProducts = this.products.filter((p)=>{return p.name == this.searchValue});
        },
        handleSizeChange(size){
            this.pageSize = size;
            this.updateDisplay();
        },
        handleCurrentChange(page){
            this.currentPage = page;
            this.updateDisplay();
        },
        updateDisplay(){
            const index = (this.currentPage - 1) * this.pageSize;
            this.displayProducts = this.products.slice(index, index + this.pageSize);
        }
    },
    mounted() {
        axios.get("http://localhost:3000/product").then((result) => {
            this.products = result.data;
            this.total = this.products.length;
            this.updateDisplay();
        })
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
</style>