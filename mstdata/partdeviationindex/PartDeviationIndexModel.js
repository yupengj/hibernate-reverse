Ext.define('gantang.mstdata.partdeviationindex.PartDeviationIndexModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'partId',
			type : 'number'
		},{
		name : 'errandTopLimit',
			type : 'number'
		},{
		name : 'errandBottomLimit',
			type : 'number'
		},{
		name : 'analysis',
			type : 'string'
		},{
		name : 'errandType',
			type : 'string'
		},{
		name : 'partDeviationIndexExtId',
			type : 'number'
		},{
	}]
});