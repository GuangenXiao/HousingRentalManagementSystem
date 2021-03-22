package ie.ul.cs4227.Bass.Service.PlugableAdapter;

import ie.ul.cs4227.Bass.Entity.Visitor;

public interface Client {

	   public Visitor doTheThing(ITarget target);

}
