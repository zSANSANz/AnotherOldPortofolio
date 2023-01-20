// pw = ProteusWidgets
var pw = pw || {};

/**
 * MediaUploader class, constructor
 * @return void
 */
pw.mediaUploader = function( frameOptions ) {
	'use strict';

	// cache jQuery variable to local property
	this.$ = jQuery;

	// urlInputId is undefined at first
	this.urlInputId = undefined;

	// prepare options and create new frame
	this.frameOptions = this.$.extend( {}, this.frameDefaults, frameOptions );
	this.fileFrame = this.createFileFrame();

	// event listeners
	this.fileFrame.on( 'select', this.onFrameSelect, this );

	// good practice, for chaining
	return this;
};

jQuery.extend( pw.mediaUploader.prototype, {

	// default options, can be overriden when initialized
	frameDefaults: {
		title:    'Choose a file',
		button:   { text: 'Select' },
		multiple: false
	},

	/**
	 * Create new file frame. This function should be only called once.
	 *
	 * Should be improved with _.once() from underscorejs
	 *
	 * @return {wp media frame}
	 */
	createFileFrame: function() {
		var fileFrame = wp.media.frames.fileFrame = wp.media( this.frameOptions );

		return fileFrame;
	},

	/**
	 * Set the URL where the file frame will return value and open it.
	 * @param  {string} urlInputId
	 * @return {this}
	 */
	openFileFrame: function ( urlInputId ) {
		// set the prop urlInputId to passed value
		this.urlInputId = urlInputId;

		this.fileFrame.open();

		return this;
	},

	/**
	 * Event handler - when the user confirms the selection he made.
	 * @return {this}
	 */
	onFrameSelect: function() {
		// read the json data returned from the Media uploader
		var json = this.fileFrame.state().get( 'selection' ).first().toJSON();

		// test if the URL is here
		if ( 0 > this.$.trim( json.url.length ) ) {
			return;
		}

		//add the URL value to the appropriate URL input field
		this.$( '#' + this.urlInputId ).val( json.url );

		this.urlInputId = undefined;

		return this;
	},

} );

// initialization
pw.mediaUploaderTmp = new pw.mediaUploader();