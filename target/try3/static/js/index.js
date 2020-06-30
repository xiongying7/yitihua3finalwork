'use strict';

document.documentElement.addEventListener('mousemove', function(e) {
    document.body.style.setProperty('--posX', e.clientX + 'px');
    document.body.style.setProperty('--posY', e.clientY + 'px');
});