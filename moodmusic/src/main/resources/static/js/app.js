let allSongs = []
let favorites = []
let recent = []

function loadSongs(mood){

fetch("/api/music/"+mood)
.then(res=>res.json())
.then(data=>{

allSongs=data
displaySongs(data)

})

}

function displaySongs(songs){

const container=document.getElementById("songs")
container.innerHTML=""

songs.forEach(song=>{

container.innerHTML+=`

<div class="bg-gray-600 p-2 rounded mb-3 flex items-center gap-3 cursor-pointer"
onclick="playSong('${song.url}','${song.title}','${song.artist}')">

<img src="${song.image}" width="50" class="rounded">

<div>
<p class="font-bold">${song.title}</p>
<p class="text-sm">${song.artist}</p>
</div>

<button onclick="addFavorite(event,'${song.title}','${song.artist}','${song.url}','${song.image}')">
❤️
</button>

</div>
`

})

}

function playSong(url,title,artist){

let player = document.getElementById("player")

// force youtube embed format
player.src = url + "?autoplay=1&mute=0&controls=1&modestbranding=1"

document.getElementById("nowPlaying").innerText =
"Now Playing: " + title + " - " + artist

addRecent(title,artist)

}

function addFavorite(e,title,artist,url,image){

e.stopPropagation()

// check duplicate
let exists = favorites.find(s => s.title === title)

if(exists){
return
}

favorites.push({title,artist,url,image})

let fav=document.getElementById("favorites")
fav.innerHTML=""

favorites.forEach(s=>{

fav.innerHTML+=`
<div class="mb-2 flex items-center gap-2">

<img src="${s.image}" width="40">

<div>
<p>${s.title}</p>
<p class="text-sm">${s.artist}</p>
</div>

</div>
`

})

}

function addRecent(title,artist){

// remove same song if already exists
recent = recent.filter(r => r.title !== title)

recent.unshift({title,artist})

if(recent.length > 5){
recent.pop()
}

let rec=document.getElementById("recent")
rec.innerHTML=""

recent.forEach(r=>{

rec.innerHTML+=`
<p>${r.title} - ${r.artist}</p>
`

})

}

function detectMood(){

let text=document.getElementById("moodText").value.toLowerCase()

let mood="happy"

if(text.includes("sad")) mood="sad"
if(text.includes("love")) mood="romantic"
if(text.includes("tired")) mood="relax"

document.getElementById("detectedMood").innerText="Detected Mood : "+mood

loadSongs(mood)

}

function fullscreen(){

let player=document.getElementById("player")

if(player.requestFullscreen){
player.requestFullscreen()
}

}

function minimize(){

document.exitFullscreen()

}

document.getElementById("search").addEventListener("keyup",function(){

let text=this.value.toLowerCase()

let filtered=allSongs.filter(s=>

s.title.toLowerCase().includes(text) ||
s.artist.toLowerCase().includes(text)

)

displaySongs(filtered)

})
