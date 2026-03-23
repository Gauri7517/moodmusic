async function register(){

let username = document.getElementById("username").value
let password = document.getElementById("password").value

const res = await fetch("/api/auth/register",{
method:"POST",
headers:{
"Content-Type":"application/json"
},
body:JSON.stringify({
username:username,
password:password
})
})

let msg = await res.text()

alert(msg)

// redirect to login page
window.location.href = "login.html"

}