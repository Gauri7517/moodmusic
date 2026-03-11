// LOGIN FUNCTION
async function login(){

let username = document.getElementById("username").value.trim()
let password = document.getElementById("password").value.trim()

// check empty fields
if(username === "" || password === ""){

alert("Please enter username and password")
return

}

try{

const res = await fetch("/api/auth/login",{

method: "POST",

headers:{
"Content-Type":"application/json"
},

body: JSON.stringify({
username: username,
password: password
})

})

if(!res.ok){

alert("Server error")
return

}

let user = await res.json()

// check if user returned
if(user && user.username){

// save logged user
localStorage.setItem("user", user.username)

// redirect to main app
window.location.href = "index.html"

}else{

alert("Invalid username or password")

}

}catch(error){

console.error(error)
alert("Login failed. Please try again.")

}

}