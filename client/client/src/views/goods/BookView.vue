<template>
    <div>
        <el-dialog :visible.sync="dialogTableVisible" title="商品详情" :close-on-click-modal="false" >
            <div style="display: flex;">
                <span style="margin-right: 20px">
                    <img :src="showProduct.img" alt="商品图片" style="height: 200px" />
                </span>
                <span style="font-size: 20px; font-weight: 800">
                    <p>商品名称： {{ showProduct.name }}</p>
                    <p>商品价格： ¥{{ showProduct.price }}</p>
                    <p>商品种类： {{ showProduct.category }}</p>
                    <p>商品存货量： {{ showProduct.stock }}</p>
                </span>
            </div>
        </el-dialog>

        <el-dialog :visible.sync="dialogFormVisible" title="新增商品信息" :close-on-click-modal="false"> 
            <el-form ref="form" :model="form" label-width="80px">
                <el-form-item label="商品名称" prop="name" :rules="[
                    { required: true, message: '商品名不能为空'},
                    ]"
                >
                    <el-input v-model="form.name"></el-input>
                </el-form-item>

                <el-form-item label="商品数量" prop="stock" :rules="[
                    { required: true, message: '数量不能为空'},
                    { type: 'number', message: '数量必须为数字值'}
                    ]"
                >
                    <el-input v-model.number="form.stock" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品单价" prop="price" :rules="[
                    { required: true, message: '价格不能为空'},
                    { type: 'number', message: '价格必须为数字值'}
                    ]"
                >
                    <el-input v-model.number="form.price" autocomplete="off"></el-input>
                </el-form-item>

                <el-form-item label="商品种类" prop="category" :rules="[
                    { required: true, message: '种类不能为空'},
                    ]"
                >
                    <el-select v-model="form.category" placeholder="请选择商品种类">
                    <el-option label="书籍" value="book"></el-option>
                    <el-option label="食品" value="food"></el-option>
                    <el-option label="交通工具" value="vehicle"></el-option>
                    </el-select>
                </el-form-item>

                <el-form-item label="商品图片">
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
                    <el-button type="primary" @click="addProduct">提交</el-button>
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
                        <div class="search-container">
                            
                            <el-input v-model="searchValue" placeholder="请输入商品名称" @keyup.enter="handleSearch" clearable>
                                <el-button slot="append" icon="el-icon-search" @click="handleSearch"></el-button>
                            </el-input>
                        </div>
                    </el-header>
                    
                    <el-main style="background-color: #fff; color: #333">
                        <el-row class="product-grid">
                            <el-col :span="6" v-for="product in displayProducts" :key="product.id">
                                <el-card :header="truncateText(product.name)" style="font-size: 20px; font-weight: 600;">
                                    <div style="display: flex; justify-content: space-between">
                                        <span @click="showDetail(product)">
                                            <img :src="product.img" class="product-image" />
                                        </span>
                                        <el-input-number v-model="product.quantity" @change="handleQuantity(product.quantity, product.id, product.price)" :min="0" :max="10" label="count" style="z-index: 0"></el-input-number>
                                    </div>
                                    <div>
                                        价格：¥{{ product.price }}
                                    </div>
                                </el-card>
                            </el-col>
                        </el-row>

                    </el-main>

                    <el-footer style="margin-bottom: 60px">
                        <el-pagination background layout="sizes, prev, pager, next, jumper, total" 
                            @size-change="handleSizeChange"
                            @current-change="handleCurrentChange"
                            :total="total"
                            :page-sizes="[12, 24, 36, 48]"
                            :page-size="pageSize">
                        </el-pagination>
                    </el-footer>
                    <el-footer class="footer">
                        <div><el-button type="primary" style="line-height: 20px; font-size: 30px; font-weight: 1000" @click="dialogFormVisible = true">新增商品</el-button></div>
                        <div>
                            <span style="line-height: 60px; font-size: 40px; font-weight: 1000">当前已选择商品总价：</span>
                            <span style="line-height: 60px; font-size: 40px; font-weight: 1000; color: red">{{ $store.state.totalPrice }}</span>
                        </div>
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

            filterProducts: [],
            displayProducts: [],

            // 分页
            total: 0,
            pageSize: 12,
            currentPage: 1,

            // 详细信息可见
            dialogTableVisible: false,
            dialogFormVisible: false,
            showProduct: {
                "id": "1",
                "_id": "1",
                "price": "3",
                "category": "drink",
                "quantity": 0,
                "name": "cola",
                "stock": 1,
                "img": "Cola.jpg",
            },

            // 新增商品
            form: {
                name: '',
                stock: 0,
                price: 0,
                category: '',
                img: '',
            },
        }
    },
    methods: {
        handleSearch(){
            this.filterProducts = this.products.filter(p => this.searchValue === "" || p.name.includes(this.searchValue));
            this.total = this.filterProducts.length;
            this.pageSize = 12;
            this.currentPage = 1;
            this.updateDisplay();
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
            this.displayProducts = this.filterProducts.slice(index, index + this.pageSize);
        },
        addProduct(){
            this.$refs.form.validate(valid => {
                if (valid) {
                    axios.post(this.$store.state.backendPort + '/product/uploadProduct', this.form, {
                        headers: {
                            'Content-Type': 'application/json',
                            'token': this.$store.state.user.token,
                        }}
                    )
                    .then(response => {
                        console.log(response.data.data);
                    })
                    .catch(error => {
                        if(error.data.code == -2){
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
        handleQuantity(num, id, price){
            this.$store.commit('changeProductQuantity', {'num': num, 'id': id, 'price': price});
        },
        showDetail(product){
            this.showProduct = product;
            this.dialogTableVisible = true;
        },
        uploadUrl(path){
            return this.$store.state.backendPort + path;
        },
        loadImgUrl(response){
            this.form.img = response.data;
        },
        truncateText(name){
            const maxLength = 10; // 设置最大长度
            return name.length > maxLength ? name.slice(0, maxLength) + '...' : name;
        }
    },
    mounted() {
        axios.get(this.$store.state.backendPort + "/product",{
            headers: {
                'token': this.$store.state.user.token,
            }
        }).then((result) => {
            this.products = result.data;

            this.showProduct = this.products[0];

            this.filterProducts = this.products.filter(p => p.category === 'book');
            this.total = this.filterProducts.length;
            this.updateDisplay();
            this.$store.state.productsInCar.forEach(info => {
                this.filterProducts.forEach(p => {
                    if(p.id === info.id){
                        p.quantity = info.quantity;
                    }
                })
            });
        }).catch(error => {
            if(error.data.code == -2){
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