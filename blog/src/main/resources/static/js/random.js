let bgRan = Math.floor(Math.random()*8+1);
let avatarRan=Math.floor(Math.random()*8+1);
$('#minister').css('background','url(/css/img/blog/background'+bgRan+'.jpg)no-repeat')
$('#avatar_image').attr('src','/css/img/random_avatar/avatar'+avatarRan+'.jpg')