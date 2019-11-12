=begin
# concern are used for some extra data functionality

# in rails module name & file name must match
module CurrentUserConcern
  # default extend for concern
  extend ActiveSupport::Concern

  # devise method overrided
	def current_user
    # if user exists call original mehtod back from devise
		# or
		# if doesn't than create guest user
    super || guest_user
  end

  def guest_user
    OpenStruct.new(name: "guest user", first_name: "guest", last_name: "user", email: "guest@example.com")
  end
end
=end
