Ext.define('gantang.mstdata.blockencoding.BlockEncodingModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'blockEncodingExtId',
			type : 'number'
		},{
		name : 'partGroupCode',
			type : 'string'
		},{
		name : 'partGroupName',
			type : 'string'
		},{
		name : 'partGroupNameEn',
			type : 'string'
		},{
		name : 'partTypeId',
			type : 'number'
		},{
		name : 'measurementUnit',
			type : 'string'
		},{
		name : 'ieIdentifyCode',
			type : 'string'
		},{
		name : 'isEffective',
			type : 'boolean'
		},{
		name : 'effectiveFrom',
			type : 'date'
		},{
		name : 'effectiveTo',
			type : 'date'
		},{
	}]
});