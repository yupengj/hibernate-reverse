Ext.define('gantang.mstdata.partname.PartNameModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'partNameZh',
			type : 'string'
		},{
		name : 'partNameEn',
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
		name : 'partNameExtId',
			type : 'number'
		},{
	}]
});