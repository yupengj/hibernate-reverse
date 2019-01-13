Ext.define('gantang.mstdata.address.AddressModel', {
	extend : 'gantang.model.AuditModel',
	fields : [{
		name : 'country',
			type : 'string'
		},{
		name : 'province',
			type : 'string'
		},{
		name : 'city',
			type : 'string'
		},{
		name : 'address',
			type : 'string'
		},{
		name : 'zipCode',
			type : 'string'
		},{
		name : 'zone',
			type : 'string'
		},{
		name : 'addressExtId',
			type : 'number'
		},{
	}]
});