Ext.define('gantang.mstdata.materialgroup.MaterialGroupModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'groupCode',
			type : 'string'
		},{
		name : 'groupName',
			type : 'string'
		},{
		name : 'groupNameEn',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'materialGroupExtId',
			type : 'number'
		},{
	}]
});