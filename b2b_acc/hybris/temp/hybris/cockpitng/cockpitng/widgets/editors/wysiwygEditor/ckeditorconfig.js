CKEDITOR.editorConfig = function(config) {

    config.toolbar = [
        { name: 'styles', items: [ 'Format' ] },
        { name: 'basicstyles', items: [ 'Bold', 'Italic' ] },
        { name: 'links', items: [ 'Link' ] },
        { name: 'paragraph', items: [ 'BulletedList' ] },
        { name: 'document', items: [ 'Source' ] },
        { name: 'clipboard', items: [ 'Undo', 'Redo' ] }
    ];

    config.contentsCss = 'widgetClasspathResource/widgets/editors/wysiwygEditor/validationstyles.css';

    // replace part of CKEditor base path to allow load skin from wysiwyg widget directory
    // (CKEditor path contains protocol, domain, port and application root path)
    config.skin = 'bootstrapck,' + CKEDITOR.basePath.replace('zkau/web/js/ckez/ext/CKeditor/', 'widgetClasspathResource/widgets/editors/wysiwygEditor/vendor/skins/bootstrapck-1.0.0/');
};

CKEDITOR.on('instanceReady', function( ev ) {
    ev.editor.dataProcessor.writer.setRules( 'p', {
       breakAfterClose : false
    });
});