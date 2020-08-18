
var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Menu = Pluswerk.HSTrier.Menu || {};

Pluswerk.HSTrier.Menu.MainMenuController = function () {

    var layerOpen = false;
    var $window = $(window);
    var isMobile,
        lastViewPort,
        resizeTimer;
    var _this = this;

    this.isMobileViewport = function () {
        return $window.width() < 993;
    };

    this.initNavToggle = function () {
        $('.main-nav-toggle').on('click', function () {

            if (_this.isMobileViewport()) {
                $('body').toggleClass('main-nav-mobile-isopen');

                // close location-nav or quicklinks
                if ($('body.location-nav-isopen-mobile').length) {
                    $('body').removeClass('location-nav-isopen-mobile');
                } else if ($('body.quicklinks-nav-isopen-mobile').length) {
                    $('body').removeClass('quicklinks-nav-isopen-mobile');
                }
                [].slice.call(document.querySelectorAll('[data-menu-toggle-class]')).forEach(function(o) {
                    o.classList.remove(o.getAttribute('data-menu-toggle-class'));
                });

            } else {
                $('#js-main-nav').find('.main-nav-list__item.main-nav-list__item--open > a').click();
            }

        });
    };

    this.destroyMobile = function () {
        // remove events from control elements
        $('#js-main-nav [data-control]').unbind('click').unbind('accordion.toggle');
        $window.unbind('resize.accordion');

        // remove accordion classes and inline styles
        $('#js-main-nav .accordion--open').removeClass('accordion--open');
        $('#js-main-nav [data-content]').removeAttr('style');

        // remove toggle flagClass
        $('body').removeClass('main-nav-mobile-isopen');

        // close other menues
        $('body').removeClass('location-nav-isopen-mobile');
        $('body').removeClass('quicklinks-nav-isopen-mobile');
        $('.top-bar-nav .language-menu').removeClass('language-menu--open');

        // remove accordion plugin
        $('#js-main-nav .main-nav-list__item[data-dropdown="true"]').unbind().removeData();
    };

    this.destroyDesktop = function () {

        // unbind click
        $('.main-nav-list__item[data-dropdown="true"] > a').unbind('click');

        // remove classes and inline styles
        $('body').removeClass('main-nav-isopen');
        $('.main-nav-list__item--open').removeClass('main-nav-list__item--open');
        $('.main-nav-list__wrapper').removeAttr('style');

        // close other menues
        $('body').removeClass('location-nav-isopen-desktop');
        $('body').removeClass('quicklinks-nav-isopen-desktop');
        $('.top-bar-nav .language-menu').removeClass('language-menu--open');

        // set variables to default
        layerOpen = false;
    };

    this.initMobile = function () {
        $('#js-main-nav .main-nav-list__item[data-dropdown="true"]').accordion({
            "transitionSpeed": 300,
            "singleOpen": true
        });
        // remove location-nav class
        $('body').removeClass('location-nav-isopen-desktop');
        $('body').removeClass('quicklinks-nav-isopen-desktop');

        lastViewPort = 'mobile';
    };

    this.initDesktop = function () {
        $('.main-nav-list__item[data-dropdown="true"] > a').on('click', function (e) {
            var _this = $(this);

            // initial open
            if (!layerOpen) {
                layerOpen = true;
                $('body').addClass('main-nav-isopen');

                // close other menue
                $('body').removeClass('location-nav-isopen-desktop');
                $('body').removeClass('quicklinks-nav-isopen-desktop');
                $('.top-bar-nav .language-menu').removeClass('language-menu--open');

                setTimeout(function () {
                    _this.parent('li').toggleClass('main-nav-list__item--open');
                }, 50);
                _this.siblings('.main-nav-list__wrapper').css({'display': 'flex'});
            } else {

                // click on already opened menu
                if (_this.parent().hasClass('main-nav-list__item--open')) {
                    layerOpen = false;

                    _this.parent('li').toggleClass('main-nav-list__item--open');
                    $('body').removeClass('main-nav-isopen');
                    _this.siblings('.main-nav-list__wrapper').removeAttr('style');
                } else {
                    // close others first
                    $('.main-nav-list__item--open > .main-nav-list__wrapper').removeAttr('style');
                    $('.main-nav-list__item--open').toggleClass('main-nav-list__item--open');
                    layerOpen = false;
                    // click (initial open)
                    _this.click();
                }
            }

            return false;
        });

        lastViewPort = 'desktop';
    };

    this.mainInit = function () {
        isMobile = this.isMobileViewport();
        isMobile = this.initNavToggle();

        if ($window.width() > 993) {
            this.initDesktop();
        } else {
            this.initMobile();
        }

        $window.on('resize', function () {
            isMobile = _this.isMobileViewport();
            var currentViewPort = $window.width() < 993 ? 'mobile' : 'desktop';

            clearTimeout(resizeTimer);
            resizeTimer = setTimeout(function () {

                if (currentViewPort !== lastViewPort) {
                    if (isMobile) {
                        _this.destroyDesktop();
                        _this.initMobile();
                    } else {
                        _this.destroyMobile();
                        _this.initDesktop();
                    }
                }

            }, 250);
        });
    };

    this.reInitifOpen = function () {
        // reInit if main-nav is open (history back)
        if ($("body").hasClass("main-nav-isopen") || $("body").hasClass("main-nav-mobile-isopen")) {
            if ($window.width() > 993) {
                _this.destroyDesktop();
                _this.initDesktop();
            } else {
                _this.destroyMobile();
                _this.initMobile();
            }
        }
    };

};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Menu = Pluswerk.HSTrier.Menu || {};

Pluswerk.HSTrier.Menu.LocationMenuController = function () {

    this.mainInit = function () {
        $('.js-location-toggle-desktop').on('click', function (e) {
            e.preventDefault();

            if ($('body.quicklinks-nav-isopen-desktop').length) {
                $('body').removeClass('quicklinks-nav-isopen-desktop');
                $('body').toggleClass('location-nav-isopen-desktop');
            } else {
                $('body').toggleClass('location-nav-isopen-desktop');
            }
        });
        $('.js-location-toggle-mobile').on('click', function (e) {
            e.preventDefault();

            if ($('body.quicklinks-nav-isopen-mobile').length) {
                $('body').removeClass('quicklinks-nav-isopen-mobile');
                $('body').toggleClass('location-nav-isopen-mobile');
            } else {
                $('body').toggleClass('location-nav-isopen-mobile');
            }
        });
    };
};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Menu = Pluswerk.HSTrier.Menu || {};

Pluswerk.HSTrier.Menu.LanguageMenuController = function () {
    var $languageToggles = [].slice.call(document.querySelectorAll('.language-toggle'));

    this.mainInit = function () {
        $languageToggles.forEach(function ($languageToggle) {
            $languageToggle.addEventListener('click', function () {
                var $parent = $languageToggle.parentElement;
                var $toggle = 'language-menu--open';

                // toggle open modifier class to list
                $parent.classList.toggle($toggle);

                // close other toggle menues
                $parent.setAttribute('data-menu-toggle-class', $toggle);
                [].slice.call(document.querySelectorAll('[data-menu-toggle-class]')).forEach(function(o) {
                    if (o != $parent) 
                        o.classList.remove(o.getAttribute('data-menu-toggle-class'));
                });
            });
        });
    };

};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Menu = Pluswerk.HSTrier.Menu || {};

Pluswerk.HSTrier.Menu.LoggedinMenuController = function () {
    var $loggedinToggles = [].slice.call(document.querySelectorAll('.loggedin-toggle'));

    this.mainInit = function () {
        $loggedinToggles.forEach(function ($loggedinToggle) {
            $loggedinToggle.addEventListener('click', function () {
                var $parent = $loggedinToggle.parentElement;
                var $toggle = 'loggedin-menu--open';

                // toggle open modifier class to list
                $parent.classList.toggle($toggle);

                // close other toggle menues
                $parent.setAttribute('data-menu-toggle-class', $toggle);
                [].slice.call(document.querySelectorAll('[data-menu-toggle-class]')).forEach(function(o) {
                    if (o != $parent) 
                        o.classList.remove(o.getAttribute('data-menu-toggle-class'));
                });
            });
            // this handles LanguageMenu too
            [ '.top-bar-nav', '.main-nav-list__mobile-bar'].forEach(function($selector) {
                document.querySelector($selector).addEventListener('mouseleave', function() {
                    [].slice.call(document.querySelectorAll('[data-menu-toggle-class]')).forEach(function(o) {
                        o.classList.remove(o.getAttribute('data-menu-toggle-class'));
                    });
                });
            });
        });
    };

};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Menu = Pluswerk.HSTrier.Menu || {};

Pluswerk.HSTrier.Menu.QuicklinksMenuController = function () {

    this.mainInit = function () {
        $('.js-quicklinks-toggle-desktop').on('click', function (e) {
            e.preventDefault();

            if ($('body.location-nav-isopen-desktop').length) {
                $('body').removeClass('location-nav-isopen-desktop');
                $('body').toggleClass('quicklinks-nav-isopen-desktop');
            } else {
                $('body').toggleClass('quicklinks-nav-isopen-desktop');
            }
        });
        $('.js-quicklinks-toggle-mobile').on('click', function (e) {
            e.preventDefault();

            if ($('body.location-nav-isopen-mobile').length) {
                $('body').removeClass('location-nav-isopen-mobile');
                $('body').toggleClass('quicklinks-nav-isopen-mobile');
            } else {
                $('body').toggleClass('quicklinks-nav-isopen-mobile');
            }
        });
    };
};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Main = Pluswerk.HSTrier.Main || {};

/**
 * LightboxController
 *
 * @constructor
 */
Pluswerk.HSTrier.Main.LightboxController = function () {
    var $lightboxElements = $('.image-lightbox');

    this.mainInit = function () {
        if ($lightboxElements.index() > -1) {

            //translation
            var languageNeedle = "/en/";
            var ofLabel = (window.location.href.indexOf(languageNeedle) > -1) ? "of" : "von";

            //initialize lightbox if elements on page
            $lightboxElements.magnificPopup({
                type: 'image',
                closeOnContentClick: true,
                closeBtnInside: true,
                fixedContentPos: true,
                mainClass: 'mfp-no-margins mfp-with-zoom', // class to remove default margin from left and right side
                tLoading: 'Lade Bild #%curr%...',
                gallery: {
                    enabled: true,
                    navigateByImgClick: true,
                    preload: [ 0, 1 ], // Will preload 0 - before current, and 1 after the current image
                    tCounter: '<span class="mfp-counter">%curr% ' + ofLabel + ' %total%</span>'
                },
                image: {
                    verticalFit: true,
                    titleSrc: function (item) {
                        //return item.el.attr('title') ? item.el.attr('title') : null;
                        return $(item.el).siblings('.image__caption').text().length > 0 ? $(item.el).siblings('.image__caption').text() : null;
                    }
                },
                zoom: {
                    enabled: true,
                    duration: 300
                },
                callbacks: {
                    open: function () {
                        $('body').swipe({
                            swipe: function (event, direction) {
                                if (direction === 'right') {
                                    $('.mfp-arrow-left').click();
                                }
                                if (direction === 'left') {
                                    $('.mfp-arrow-right').click();
                                }
                            },
                            threshold: 0
                        });
                    },
                    close: function () {
                        $('body').swipe('destroy');
                    }
                }
            });
        }
    }

};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};
Pluswerk.HSTrier.Search = Pluswerk.HSTrier.Search || {};

Pluswerk.HSTrier.Search.SearchLayerController = function () {
    this.mainInit = function () {
        $('.search-button-toggle').on('click', function () {
            // close location-nav or quicklinks
            if ($('body.location-nav-isopen-desktop').length) {
                $('body').removeClass('location-nav-isopen-desktop');
            } else if ($('body.quicklinks-nav-isopen-desktop').length) {
                $('body').removeClass('quicklinks-nav-isopen-desktop');
            } else if ($('body.main-nav-mobile-isopen').length) {
                $('body').removeClass('main-nav-mobile-isopen');
            }

            $('body').toggleClass('search-isopen');

            // if body has class "search-isopen" => focus search
            if($('body').hasClass('search-isopen')) {
                setTimeout(function (){
                    $('.search-layer .search-form__input').focus();
                }, 800);
            }
        });

        $('.search-form-toggle').on('click', function (){
            $('body').removeClass('search-isopen');
        });
    };
};

var Pluswerk = Pluswerk || {};
Pluswerk.HSTrier = Pluswerk.HSTrier || {};

var mainMenuController = new Pluswerk.HSTrier.Menu.MainMenuController();
var locationMenuController = new Pluswerk.HSTrier.Menu.LocationMenuController();
var quicklinksMenuController = new Pluswerk.HSTrier.Menu.QuicklinksMenuController();
var languageMenuController = new Pluswerk.HSTrier.Menu.LanguageMenuController();
var loggedinMenuController = new Pluswerk.HSTrier.Menu.LoggedinMenuController();
var lightboxController = new Pluswerk.HSTrier.Main.LightboxController();
var searchLayerController = new Pluswerk.HSTrier.Search.SearchLayerController();

$(document).ready(function () {
    mainMenuController.mainInit();
    locationMenuController.mainInit();
    quicklinksMenuController.mainInit();
    languageMenuController.mainInit();
    loggedinMenuController.mainInit();
    lightboxController.mainInit();
    searchLayerController.mainInit();
});

window.onpageshow = function (event) {
    mainMenuController.reInitifOpen();
};



// back-to-top-Button

$(document).ready(function(){

    $(window).scroll(function(){
        if ($(this).scrollTop() > 100) {
            $('.scrollToTop').fadeIn();
        } else {
            $('.scrollToTop').fadeOut();
        }
    });

    //Click event to scroll to top
    $('.scrollToTop').click(function(){
        $('html, body').animate({scrollTop : 0},800);
        return false;
    });

});
