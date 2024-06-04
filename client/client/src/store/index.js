import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    totalPrice: 0,
    productsInCar: [],
    backendPort: "http://localhost:3000",
    user: {
      username: '',
      email: '',
      address: '',
      token: '',
      img: '',
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
      state.identity = info.token;

      state.username = info.userInfo.username;
      state.email = info.userInfo.email;
      state.address = info.userInfo.address;
      state.img = info.userInfo.img;
      state.balance = info.userInfo.balance;
    }
  },
  actions: {
  },
  modules: {
  }
})
