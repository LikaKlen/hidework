

<script >
export default{
  name:'HomePage',
  data(){
    return{

    }
  },
  methods:{
    page_reg(){
      window.location.href="/reg"
    },
    page_log(){
      window.location.href="/log"
    }
  }
}

</script>

<template>
<div class="All">
  <header>
    <div class="First">
      <img src="" alt="">
    </div>
    <span class="tilte"></span>
    <nav>
      <ul class="nav">
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><a href=""></a></li>
        <li><button class="logBT"  @click="page_log()">Войти</button></li>
        <li>  <button class="regBT" @click="page_reg()" href="/reg">Регистрация</button></li>
      </ul>
    </nav>
  </header>
  <main>
    <div class="Reg_log">
      <div class="log">
      <button class="logBT"  @click="page_log()">Войти</button>
    </div>
    <div class ="reg">
      <button class="regBT" @click="page_reg()" href="/reg">
        зарегистрироваится
      </button>
    </div>
    </div>
    
  </main>
  <footer>
    
  </footer>
</div>
  
</template>

<style scoped>
.All{
  display: column;
    align-items: center;
    justify-content:space-around;
    width: 100%;
    max-height:100vh;
  

}
.logBT{
  background: rgb(255,255,255);
background: linear-gradient(241deg, rgba(0,254,255,1) 0%, rgba(252,0,255,1) 100%);
  animation: gradient 5s infinite linear;
  background-size: 400%;
  width: auto;
  height: auto;
  /* background-color: rgb(203, 148, 255); */
  color: aliceblue;
  border-color: azure;
  border-radius: 35px;
  font-size: 35px;
}
.regBT{
  background: rgb(255,255,255);
  background: linear-gradient(241deg, rgba(0,254,255,1) 0%, rgba(252,0,255,1) 100%);
  animation: gradient 5s infinite linear;
  background-size: 400%;
  width: auto;
  height: auto;
  color: aliceblue;
  background-color: rgb(203, 148, 255);
  border-color: azure;
  border-radius: 35px;
  font-size: 35px;
  

}
header {
  width: 100%;
  max-width: 1180px;
  margin: 0 auto;
  padding-left: 15px;
  padding-right: 15px;
  display: flex;
  justify-content: space-between;
  align-items: center;
  box-sizing: border-box;
  border-top: 5px solid black;
  border-bottom: 5px solid black;
}
.text {
  text-decoration: none;
  color: #000;
  font-size: 30px;
}

.nav {
  list-style-type: none;
  display: flex;
  justify-content: flex-start;
  align-items: center;
}

.nav>li a {
  margin-left: 15px;
  text-decoration: none;
  color: #000;
}

.First{
  width: 100%;
  height: 100%;
  margin-top: 20%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 50px;
  color: blueviolet;
  font-weight:bold;
}

.Reg_log{
  width: 100%;
  height: 100%;
  margin-top: 10vh;
  margin-bottom: 20%;
  flex-direction: column;
  display: flex;
  justify-content:space-around;
  align-items: center;
  font-size: 35px;
  color: blueviolet;
  font-weight:bold;
}
.log{
  height: auto;
  width: auto;
  align-items: center;
  justify-content:space-around;
  margin-bottom:3vh;
}
.reg{
  height: auto;
  width: auto;
}

@keyframes gradient {
    0% {
        background-position: 80% 0%;
    }
    50% {
        background-position: 20% 100%;
    }
    100% {
        background-position: 80% 0%;
    }
  }

</style>


