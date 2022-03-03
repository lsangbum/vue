// HTML 코드는 template 안에
<template>

  <div class="black-bg" v-if=" popUpOnOff == true">
    <div class="white-bg">
        <h4>{{ oneRooms[0].title }}</h4>
        <p>{{ oneRooms[0].content }}</p>
        <button @click="popUpOnOff = false">닫기</button>
    </div>
  </div>


  <div class="menu">
    <a href="https://www.naver.com" v-for="(a, i) in menus" :key="i"> {{ a }} </a>
  </div>

  <div v-for="(a, i) in oneRooms" :key="i">
    
    <img :src="oneRooms[i].image" class="room-img">
    <h4 @click="popUpOnOff = true">{{ oneRooms[i].title }}</h4>
    <p>{{ oneRooms[i].price }} 원</p>
  </div>



  <!-- <div>
    <img src="./assets/room0.jpg" class="room-img">
    <h4 @click="popUpOnOff = true">{{products[0]}}</h4>
    <p>50 만원</p>
    <button @click="clickCountMethod">허위매물신고</button> 
    <span> 신고수 : {{clickCount[0]}}</span>
  </div>
  <div>
    <img src="./assets/room1.jpg" class="room-img">
    <h4>{{products[1]}}</h4>
    <p>60 만원</p>
    <button @mouseover="overCountMethod">허위매물신고</button> 
    <span> 신고수 : {{clickCount[1]}}</span>
  </div>
  <div>
    <img src="./assets/room2.jpg" class="room-img">
    <h4>{{products[2]}}</h4>
    <p>70 만원</p>
    <button @mousewheel="wheelCountMethod">허위매물신고</button> 
    <span> 신고수 : {{clickCount[2]}}</span>
  </div> -->
</template>

// script 안에는 JS
<script>

import data from './assets/oneroom';

export default {
  name: 'App',
  //데이터를 담아두는 공간
  data() {
    return {
      oneRooms : data,
      popUpOnOff : false,
      clickCount : [0, 0, 0],
      menus : ['Home', 'Shop', 'About'],
      products : ['역삼동원룸', '천호동원룸', '마포구원룸'],
    }
  },
  methods : {
    clickCountMethod() {
      this.clickCount[0]++;
    },
    overCountMethod() {
      this.clickCount[1]++;
    },
    wheelCountMethod() {
      this.clickCount[2]++;
    }
  },
  components: {
  }
}
</script>



// style 안에는 CSS
<style>

body {
  box-sizing: border-box;
}
.black-bg {
  width: 100%; height: 100%;
  background: rgba(0, 0, 0, 0.5);
  position: fixed; padding: 20px;
}
.white-bg {
  width: 100%; background: white;
  border-radius: 8px;
  padding: 20px;
}
.room-img {
  width: 100%;
  margin-top: 40px;
}

#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

.menu {
  background: darkslateblue;
  padding: 15px;
  border-radius: 5px;
}

.menu a {
  color: white;
  padding: 10px;
}

</style>
