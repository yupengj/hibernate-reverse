Ext.define('gantang.mstdata.parttype.PartTypeModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'partTypeCode',
			type : 'string'
		},{
		name : 'partTypeName',
			type : 'string'
		},{
		name : 'partTypeDesc',
			type : 'string'
		},{
		name : 'bomPolicy',
			type : 'string'
		},{
		name : 'isMaterial',
			type : 'boolean'
		},{
		name : 'isCombined',
			type : 'boolean'
		},{
		name : 'isStatusManaged',
			type : 'boolean'
		},{
		name : 'isEcu',
			type : 'boolean'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'partTypeExtId',
			type : 'number'
		},{
		name : 'isService',
			type : 'boolean'
		},{
		name : 'receivedBomPolicy',
			type : 'string'
		},{
		name : 'isUnAccessory',
			type : 'boolean'
		},{
	}]
});