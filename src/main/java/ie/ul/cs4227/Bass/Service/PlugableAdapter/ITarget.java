package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import javax.servlet.http.HttpServletRequest;

import ie.ul.cs4227.Bass.Entity.Visitor;

public interface ITarget {
	 abstract Visitor  generatVisitorWithRequest(HttpServletRequest request);
	 abstract Visitor  generatVisitorWithIP(String ip);
}