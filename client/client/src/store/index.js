import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    totalPrice: 0,
    productsInCar: [],
    backendPort: "localhost:8080",
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
  },
  actions: {
  },
  modules: {
  }
})
