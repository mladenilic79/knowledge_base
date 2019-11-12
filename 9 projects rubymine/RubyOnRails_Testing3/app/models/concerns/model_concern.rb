# concern are used for some extra data functionality

module ModelConcern
  # default extend for concern
  extend ActiveSupport::Concern

  # instance method example
  def model_concern_instance_method
    "i am instance method from model concern"
  end

  # static method example
  def self.model_concern_static_method
    "i am static method from model concern"
  end
end
