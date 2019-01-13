Ext.define('gantang.mstdata.color.ColorModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'colorType',
			type : 'string'
		},{
		name : 'colorCode',
			type : 'string'
		},{
		name : 'colorDesc',
			type : 'string'
		},{
		name : 'colorExtId',
			type : 'number'
		},{
		name : 'pictureId',
			type : 'number'
		},{
	}]
});