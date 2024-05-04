

<script >
export default{
  name:'HomePage',
  data(){
    return{
        tilte: ""
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
      <h1 class="tilte">Добро пожаловать!{{ tilte }}</h1>
    </div>
  </header>
  <main>
    <div class="Reg_log">
      <div class="log">
      <button class="logBT"  @click="page_log()">Войти</button>
    </div>
    <div class ="reg">
      
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


