Ext.define('gantang.mstdata.plantlayout.PlantLayoutModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'layoutType',
			type : 'string'
		},{
		name : 'layoutCode',
			type : 'string'
		},{
		name : 'layoutName',
			type : 'string'
		},{
		name : 'description',
			type : 'string'
		},{
		name : 'plantId',
			type : 'number'
		},{
		name : 'parentId',
			type : 'number'
		},{
		name : 'path',
			type : 'string'
		},{
		name : 'plantLayoutExtId',
			type : 'number'
		},{
	}]
});