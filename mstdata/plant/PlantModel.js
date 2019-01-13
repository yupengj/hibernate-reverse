Ext.define('gantang.mstdata.plant.PlantModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'name',
			type : 'string'
		},{
		name : 'type',
			type : 'string'
		},{
		name : 'isVirtual',
			type : 'boolean'
		},{
		name : 'plantExtId',
			type : 'number'
		},{
	}]
});