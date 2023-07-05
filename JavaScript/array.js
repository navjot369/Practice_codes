// let ele = $('h1');
// console.log(ele);
// ele.css({color: 'green',
// backgroundColor: 'yellow',
// padding: '10px 10px',
// margin: "10px"});
// $('button').on('click',function() {
//     $('body').css('backgroundColor', 'brown');
// })
// console.log(ele.text("Hello World"));
// $('input').attr('type', 'text');
// $('li').first(2).css('color', 'red');
// $('li').last().css('color', 'blue');
// console.log($('input').val("Kidda"));
// $('li').click(function() {
//     $(this).css('color', 'aqua');
// })
// $('#text1').keyup(function() {
//     console.log($(this).val())
// })
//By default, duration of animation if 400ms.
// $("#demo").click(function() {
//     $("#demo").hide(1000);
// })
// $("#tog").click(function() {
//     $("#demo").slideToggle(500);
// })

$("#demo").click(function() {
    $("#demo").animate({}, 1200, 'linear');
});