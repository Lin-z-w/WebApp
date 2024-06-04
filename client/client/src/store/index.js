import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    totalPrice: 0,
    productsInCar: [],
    backendPort: "http://localhost:3000",
    user: {
      username: '张三',
      email: '1122334@smail.nju.edu.cn',
      address: '中南海',
      token: '',
      img: 'https://img2.baidu.com/it/u=47693696,2281322100&fm=253&fmt=auto&app=138&f=JPEG?w=608&h=583',
      telephone: '15127772888',
      balance: 0.0,
    }
  },
  getters: {
  },
  mutations: {
    changeProductQuantity(state, info){
      if(info.num === 0){
        state.productsInCar = state.productsInCar.filter(p => p.id !== info.id);
      } else{
        let inx = state.productsInCar.findIndex(inf => inf.id === info.id); 
        if(inx === -1) state.productsInCar.push({id: info.id, quantity: info.num, price: info.price});
        else state.productsInCar[inx].quantity = info.num;
      }
      let price = 0;
      for(let i = 0; i < state.productsInCar.length; i++){
        price += state.productsInCar[i].price * state.productsInCar[i].quantity;
      }
      state.totalPrice = price;
    },
    setUser(state, info){
      state.user.token = info.token;

      state.user.username = info.userInfo.username;
      state.user.email = info.userInfo.email;
      state.user.address = info.userInfo.address;
      state.user.img = info.userInfo.img;
      state.user.telephone = info.userInfo.phone;
      state.user.balance = info.userInfo.balance;
    },
    setBalance(state, info){
      state.user.balance = info.balance;
    }
  },
  actions: {
  },
  modules: {
  }
})
